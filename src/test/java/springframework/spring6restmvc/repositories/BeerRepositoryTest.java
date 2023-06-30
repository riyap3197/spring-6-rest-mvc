package springframework.spring6restmvc.repositories;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import springframework.spring6restmvc.bootstrap.BootstrapData;
import springframework.spring6restmvc.entities.Beer;
import springframework.spring6restmvc.model.BeerStyle;
import springframework.spring6restmvc.services.BeerCsvServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testGetBeerListByName() {
        Page<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(list.getContent().size()).isEqualTo(336);
    }

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("Beer119319390274kcnk308972984570235085092039294787305305235")
                    .beerStyle(BeerStyle.GOSE)
                    .upc("129470")
                    .price(new BigDecimal("12.23"))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("Beer1")
                        .beerStyle(BeerStyle.GOSE)
                        .upc("129470")
                        .price(new BigDecimal("12.23"))
                        .build());

        beerRepository.flush();
        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}