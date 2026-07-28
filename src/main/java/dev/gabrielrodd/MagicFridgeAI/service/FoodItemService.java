package dev.gabrielrodd.MagicFridgeAI.service;

import dev.gabrielrodd.MagicFridgeAI.model.FoodItemModel;
import dev.gabrielrodd.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private FoodItemRepository foodItemRepository;

    public FoodItemService (FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    //CREATE
    public FoodItemModel salvar(FoodItemModel foodSalvar) {
        return foodItemRepository.save(foodSalvar);
    }

    //GET
    public List<FoodItemModel> listar() {
        return foodItemRepository.findAll();
    }

    //GET
    public FoodItemModel listarPorId(Long id) {
        Optional<FoodItemModel> foodItemID = foodItemRepository.findById(id);
        return foodItemID.orElse(null);
    }

    //PUT
    public FoodItemModel editar(FoodItemModel foodItemEditado, Long id) {
        if (foodItemRepository.existsById(id)) {
            foodItemEditado.setId(id);
            foodItemRepository.save(foodItemEditado);
            return foodItemEditado;
        } else {
            return null;
        }
    }

    //DELETE
    public FoodItemModel deletar(Long id) {
        Optional<FoodItemModel> foodItemDelete = foodItemRepository.findById(id);
        foodItemRepository.deleteById(id);
        return foodItemDelete.orElse(null);
    }
}
