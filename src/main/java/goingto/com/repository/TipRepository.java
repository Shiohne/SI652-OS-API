package goingto.com.repository;

import goingto.com.model.interaction.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipRepository extends JpaRepository<Tip, Integer> {
    List<Tip> getByUserId(Integer id);
    List<Tip> getByLocatableId(Integer id);
}
