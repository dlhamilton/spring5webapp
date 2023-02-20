package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.LongSummaryStatistics;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
