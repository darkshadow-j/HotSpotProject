package pl.pawel.hslogs.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pawel.hslogs.model.LogsModel;

import java.sql.Time;
import java.util.List;
import java.util.Date;

@Repository
public interface LogsDAO extends JpaRepository<LogsModel, Long> {

    List<LogsModel> getLogsModelByDateAndTimeBetweenAndProgramAndMessageIsContaining(String date, String start, String stop, String program, String ip);

    List<LogsModel> getLogsModelByMessageIsContainingAndMessageIsContaining(String cont, String ip);

    LogsModel getFirstByTimeBeforeAndDateAndAndMessageIsContainingAndMessageIsContainingOrderByDateAsc(String date, String time, String ip, String program);
    List<LogsModel> getAllByTimeBeforeAndDateAndAndMessageIsContainingAndMessageIsContaining(String date, String time, String ip, String program);
}
