import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BoardRepository {
    private final EntityManager entityManager;

    public BoardRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Board> save(Board board){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(board);
            entityManager.getTransaction().commit();
            return Optional.of(board);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Board> findAll(){
        return entityManager.createQuery("from Board").getResultList();
    }

    public Optional<Board> findById(String id){
        List<Board> list =  entityManager.createQuery("select b from Board b where b.tabuleiro = "+id).getResultList();
        return Optional.of(list.get(0));
    }
}
