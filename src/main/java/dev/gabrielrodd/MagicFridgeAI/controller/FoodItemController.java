package dev.gabrielrodd.MagicFridgeAI.controller;

import dev.gabrielrodd.MagicFridgeAI.model.FoodItemModel;
import dev.gabrielrodd.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private FoodItemService foodItemService;

    //Injetando dependencia do Service
    public FoodItemController (FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    //POST
    @PostMapping("/criar")
    public ResponseEntity<FoodItemModel> criar(@RequestBody FoodItemModel foodItem) {
        return ResponseEntity.ok(foodItemService.salvar(foodItem));
    }

    //GET


    //UPDATE

    //DELETE

}
