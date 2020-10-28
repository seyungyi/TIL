# [ JPA Pagination ]

## JPA의 장점

- 개발 속도가 빠름
  - mapper의 쿼리문 작성 없이 DB 별로 다른 SQL 문법을 자동 적용해 생성해줌

## Pageable

- Spring에서 페이징 기능을 위한 파라미터들을 추상화 시킨 인터페이스

### Controller

```java
import com.devson.pagination.web.domain.BoardEntity;
import com.devson.pagination.web.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards")
    public String boardView(@PageableDefault Pageable pageable, Model model) {
        Page<BoardEntity> boardList = boardService.getBoardList(pageable);
        model.addAttribute("boardList", boardList);

        log.debug("총 element 수 : {}, 전체 page 수 : {}, 페이지에 표시할 element 수 : {}, 현재 페이지 index : {}, 현재 페이지의 element 수 : {}",
                boardList.getTotalElements(), boardList.getTotalPages(), boardList.getSize(),
                boardList.getNumber(), boardList.getNumberOfElements());

        return "board";
    }
}
```

- Debug 모드에서 확인시 pageable 객체에 page, size, sort 프로퍼티가 존재함

### Repository

- UserRepository

  ```java
  import com.devson.pagination.web.domain.UserEntity;
  import org.springframework.data.jpa.repository.JpaRepository;
  
  public interface UserRepository extends JpaRepository<UserEntity, Long> {
  }
  ```

- BoardRepository

  ```java
  import com.devson.pagination.web.domain.BoardEntity;
  import org.springframework.data.jpa.repository.JpaRepository;
  
  public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
  }
  ```

- JpaRepository 상속할 시 @Repository 필요도 없이 기본적인 CRUD를 사용할 수 있다

- @NoRepositoryBean

  - JpaRepository 소스 안에 존재하는 어노테이션
  - 해당 어노테이션이 달려있는 인터페이스를 스프링이 Repository로 등록하지 못하게 하기 위함
  - JpaRepository는 bean으로 등록되어있지 않지만 JpaRepository 상속 받은 인터페이스는 bean으로 등록이 되는 이유가 됨

  ```java
  @NoRepositoryBean
  public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
      // 생략
  }
  ```

### Service

- BoardService

  ```java
  import com.devson.pagination.web.domain.BoardEntity;
  import com.devson.pagination.web.repository.BoardRepository;
  import org.springframework.data.domain.Page;
  import org.springframework.data.domain.PageRequest;
  import org.springframework.data.domain.Pageable;
  import org.springframework.stereotype.Service;
  
  @Service
  public class BoardService {
      private BoardRepository boardRepository;
  
      public BoardService(BoardRepository boardRepository) {
          this.boardRepository = boardRepository;
      }
  
      public Page<BoardEntity> getBoardList(Pageable pageable) {
          int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
          pageable = PageRequest.of(page, 10);
  
          return boardRepository.findAll(pageable);
      }
  }
  ```

### 페이징에 필요한 데이터 넣기

- 서버 실행 후 DB에 데이터 넣어주는 테스트 코드 작성하ㅣㄱ

- Main Application class에 CommandLineRunner를 리턴하는 메서드 생성하여 코드 추가

- PaginationApplication

  ```java
  import com.devson.pagination.web.domain.BoardEntity;
  import com.devson.pagination.web.domain.UserEntity;
  import com.devson.pagination.web.repository.BoardRepository;
  import com.devson.pagination.web.repository.UserRepository;
  import org.springframework.boot.CommandLineRunner;
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.context.annotation.Bean;
  
  import java.util.stream.IntStream;
  
  @SpringBootApplication
  public class PaginationApplication {
  
      public static void main(String[] args) {
          SpringApplication.run(PaginationApplication.class, args);
      }
  
      /**
       * 154 개의 사용자와 게시물을 생성
       * @param userRepository
       * @param boardRepository
       * @return
       */
      @Bean
      public CommandLineRunner initData(UserRepository userRepository, BoardRepository boardRepository) {
          return args -> 
              IntStream.rangeClosed(1, 154).forEach(i -> {
                  UserEntity user =  UserEntity.builder()
                          .name("tester" + i)
                          .build();
  
                  userRepository.save(user);
  
                  BoardEntity board = BoardEntity.builder()
                          .title("test" + i)
                          .writer(user)
                          .build();
  
                  boardRepository.save(board);
              });
      }
  }
  ```

- 로그와 JPA가 자동으로 생성되는 SQL 쿼리 확인을 위해 application.properties에 설정 추가

  ```properties
  # application.properties
  logging.level.com.devson.pagination=debug
  
  spring.jpa.properties.hibernate.show_sql=true
  spring.jpa.properties.hibernate.format_sql=true
  
  ```

