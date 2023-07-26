package rx;

import io.reactivex.Observable;

import java.util.List;

public interface IDBRxManager {
    Observable<List<Student>> queryStudentAll();
}
