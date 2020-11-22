package Repository;
import models.Book;
import org.springframework.data.repository.CrudRepository;
import com.example.second.SecondApplication;
public interface BookRepository extends CrudRepository<Book, Integer> {

}
