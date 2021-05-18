package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.DeveloperCreate;
import fr.formation.developers.domain.dtos.DeveloperUpdate;
import fr.formation.developers.domain.dtos.DeveloperView;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final List<DeveloperView> developersRepository = new ArrayList<>();

    void createMockedData() {
        DeveloperView dev1 = new DeveloperView("Dev1", "Prenom1", "Nom1", LocalDate.of(1978,12, 13));
        DeveloperView dev2 = new DeveloperView("Dev2", "Prenom2", "Nom2", LocalDate.of(1948,11, 13));

        developersRepository.add(dev1);
        developersRepository.add(dev2);
    }

    public DeveloperServiceImpl() {
        this.createMockedData();
    }

    @Override
    public DeveloperView getByNickname(String nickname) {
        for (DeveloperView developer : developersRepository) {
            if(developer.getNickname().equals(nickname)) {
                return developer;
            }
        }
        return null;
    }

    @Override
    public void createDeveloper(DeveloperCreate developer) {
        //developersRepository.add(developer);
        System.out.println(developer);
    }

    @Override
    public void updateBirthdate(String nickname, DeveloperUpdate update) {
        for(DeveloperView item : developersRepository) {
            if (item.getNickname().equals(nickname)) {
                item.setBirthdate(update.getBirthdate());
                System.out.println(update);
            }
        }
    }
}
