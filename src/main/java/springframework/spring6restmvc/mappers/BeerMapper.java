package springframework.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import springframework.spring6restmvc.entities.Beer;
import springframework.spring6restmvc.model.BeerDTO;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);

}
