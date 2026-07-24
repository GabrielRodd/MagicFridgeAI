package dev.gabrielrodd.MagicFridgeAI.service;

import dev.gabrielrodd.MagicFridgeAI.model.FoodItemModel;
import dev.gabrielrodd.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private FoodItemRepository foodItemRepository;

    public FoodItemService (FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public FoodItemModel salvar(FoodItemModel foodSalvar) {
        return foodItemRepository.save(foodSalvar);
    }

    public List<FoodItemModel> listar() {
        return foodItemRepository.findAll();
    }

    public FoodItemModel editar(FoodItemModel foodItemEditado, Long id) {
        if (foodItemRepository.existsById(id)) {
            foodItemEditado.setId(id);
            foodItemRepository.save(foodItemEditado);
            return foodItemEditado;
        } else {
            return null;
        }
    }
}
