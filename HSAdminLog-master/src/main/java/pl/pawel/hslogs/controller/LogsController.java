package pl.pawel.hslogs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pawel.hslogs.httpclient;
import pl.pawel.hslogs.jpa.LogsDAO;
import pl.pawel.hslogs.model.LogsModel;
import pl.pawel.hslogs.model.SearchModel;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/logs")
public class LogsController {


    @Autowired
    private LogsDAO logsDAO;
    @Autowired
    private pl.pawel.hslogs.httpclient httpclient;



    @PostMapping("/search")
    public ResponseEntity<List<LogsModel>> searchLogs(@RequestBody SearchModel searchModel) throws ParseException {
        System.out.println(searchModel);
        return new ResponseEntity<>(this.getAllLogs(searchModel), HttpStatus.OK);
    }


    public List<LogsModel> getAllLogs(SearchModel searchModel) throws ParseException {
        List<LogsModel> logsModels = logsDAO.getLogsModelByDateAndTimeBetweenAndProgramAndMessageIsContaining(searchModel.getDate(), searchModel.getTimeStart(), searchModel.getTimeStop(), "firewall,info", searchModel.getIpAddress());
        List<LogsModel> resultlog = new ArrayList<>();

        logsModels.forEach(p -> {
            List<LogsModel> lsl = logsDAO.getAllByTimeBeforeAndDateAndAndMessageIsContainingAndMessageIsContaining(p.getTime(),p.getDate(), p.getIp(true), "logged in");
            LogsModel ls = null;
            if(lsl.size()>0) {
                ls = lsl.get(lsl.size() - 1);
            }
            if (ls != null) {
                ls.setLogsModel(p);
                ls.setTelephone(httpclient.getTelNumberByName(ls.getUsername()));
                System.out.println(ls);
                resultlog.add(ls);
            }
        });
        System.out.println(resultlog);


        return resultlog;
    }

    @GetMapping("/log")
    public List<LogsModel> getAllLogss() throws ParseException {

        return logsDAO.getLogsModelByMessageIsContainingAndMessageIsContaining("20.20", "logged in");
    }


}
