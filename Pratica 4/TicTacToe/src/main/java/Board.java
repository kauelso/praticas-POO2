import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_board")
public class Board {
    @Id
    String id;
    @Column(name = "tabuleiro")
    String tabuleiro;

    @Transient
    BoardRepository boardRepository;



    public Board(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TicTacToe");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        boardRepository = new BoardRepository(entityManager);
    }

    public String[] toBoard(){
        String[] board = new String[ 9 ];
        for(int i = 0; i < 9; i++){
            if(tabuleiro.charAt(i) == '-') board[i] = "";
            else board[i] = String.valueOf(tabuleiro.charAt(i));
        }
        return board;
    }

    public void setTabuleiro(String[] board){
        for(int j = 0;j<9;j++){
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < board.length; i++) {
            if(Objects.equals(board[i], "")) sb.append("-");
            else sb.append(board[i]);
        }
        this.tabuleiro = sb.toString();
    }

    public void saveTabuleiro(String id,String[] board){
        this.id = id;
        setTabuleiro(board);
        boardRepository.save(this);
    }
}
