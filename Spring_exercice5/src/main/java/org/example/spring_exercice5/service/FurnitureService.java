package org.example.spring_exercice5.service;

import org.example.spring_exercice5.entity.Furniture;
import org.example.spring_exercice5.repository.FurnitureRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public List<Furniture> getAllFurnitures() {
        return furnitureRepository.findAllByOrderByName();
    }

    public Furniture getFurnitureById(Long id) {
        return furnitureRepository.getReferenceById(id);
    }

    public void saveFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    public void deleteFurnitureById(Long id) {
        furnitureRepository.deleteById(id);
    }
}
