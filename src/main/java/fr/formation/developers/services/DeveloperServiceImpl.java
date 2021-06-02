package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.*;
import fr.formation.developers.domain.entities.Developer;
import fr.formation.developers.repositories.DeveloperRepository;
import org.springframework.stereotype.Service;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository repository;

    public DeveloperServiceImpl(DeveloperRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeveloperView getByNickname(String nickname) {
        Developer entity = repository.findByNickname(nickname).get();
        DeveloperView view = new DeveloperView();
        view.setNickname(entity.getNickname());
        view.setFirstName(entity.getFirstName());
        view.setLastName(entity.getLastName());
        view.setBirthdate(entity.getBirthdate());
        System.out.println(view);
        return view;
    }

    @Override
    public void createDeveloper(DeveloperCreate dto) {
        Developer entity = new Developer();
        entity.setNickname(dto.getNickname());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthdate(dto.getBirthdate());
        repository.save(entity);
        System.out.println(dto);
    }

    @Override
    public void updateBirthdate(String nickname, DeveloperUpdate dto) {
        Developer entity = repository.findByNickname(nickname).get();
        System.out.println(dto);
        entity.setBirthdate(dto.getBirthdate());
        repository.save(entity);
    }

    @Override
    public IDeveloperView find() {
        String lastName = "Nom3";
        String firstName= "Prenom3";

        return repository.findByFirstNameAndLastName(firstName, lastName).get();
    }
}
