package umc.spring.service.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.exception.handler.InvalidPageException;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;

    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoreByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name,score);
        filteredStores.forEach(
                store -> System.out.println("Store = " + store)
        );
        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId).get();

        if(page == null || page-1 < 0) {
            throw new InvalidPageException();

        }

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page-1,10));


        return StorePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId).get();

        if(page == null || page-1 < 0) {
            throw new InvalidPageException();
        }

        Page<Mission> storeMission = missionRepository.findAllByStore(store,PageRequest.of(page-1, 10));

        return storeMission;
    }
}
