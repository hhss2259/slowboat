package slowboat.slowboat.model.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import slowboat.slowboat.model.Entity.Boat;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultPage<T> {

    int statusCode;
    String message;
    T data;
    int pageNumber; // 현재 몇번째 페이지인지 => 0부터 시작
    int totalPages; // 총 페이지 갯수 => 1부터 시작
    int numberOfElements; // 현재 페이지에 몇개의 요소들이 있는지 => 1부터 시작
    int pageSize; //총 몇개의 페이지가 있는지 => 1부터 시작

    
    public static <T> DefaultPage res(int statusCode, String message, Page<T> page){
        DefaultPage<Object> pageCustom = new DefaultPage<>();
        pageCustom.setStatusCode(statusCode);
        pageCustom.setMessage(message);


        pageCustom.setPageNumber(page.getPageable().getPageNumber());
        pageCustom.setTotalPages(page.getTotalPages());
        pageCustom.setNumberOfElements(page.getNumberOfElements());
        pageCustom.setPageSize(page.getPageable().getPageSize());


        List<T> contents = page.getContent();
        List<BoatByCategoryResponseDto> customContents = new ArrayList<>();
        for(T boat : contents){
            BoatByCategoryResponseDto dto = new BoatByCategoryResponseDto();
            dto.makeResponse((Boat) boat);
            customContents.add(dto);
        }

        pageCustom.setData(customContents);

        return pageCustom;
    }
    

}
