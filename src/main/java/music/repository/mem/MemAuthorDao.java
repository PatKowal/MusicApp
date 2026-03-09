package music.repository.mem;

import music.model.Author;
import org.springframework.stereotype.Component;
import music.repository.AuthorDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("authorDao")
public class MemAuthorDao implements AuthorDao {
    @Override
    public List<Author> findAll() {
        return SampleData.authors;
    }

    @Override
    public Author findById(int id) {
        return SampleData.authors.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Author add(Author a) {
        int max = SampleData.authors.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        a.setId(++max);
        SampleData.authors.add(a);
        return a;
    }
}
