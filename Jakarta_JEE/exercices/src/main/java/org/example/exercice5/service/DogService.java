package org.example.exercice5.service;

import org.example.exercice5.model.Dog;
import org.example.exercice5.repository.DogRepository;

import java.time.LocalDate;
import java.util.List;

public class DogService {
    private DogRepository dogRepository;

    public DogService() {
        dogRepository = new DogRepository();
    }

    public List<Dog> getAll() {
        return dogRepository.getAll();
    }

    public void save(String name, String breed, LocalDate birthDate) {
        Dog dog = new Dog(name, breed, birthDate);
        dogRepository.save(dog);
    }

    public Dog getById(int id) {
        return dogRepository.getById(id);
    }
}
