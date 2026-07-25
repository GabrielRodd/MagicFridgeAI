package dev.gabrielrodd.MagicFridgeAI.controller;

import dev.gabrielrodd.MagicFridgeAI.model.FoodItemModel;
import dev.gabrielrodd.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private FoodItemService foodItemService;

    //Injetando dependencia do Service
    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    //POST
    @PostMapping("/criar")
    public ResponseEntity<FoodItemModel> criar(@RequestBody FoodItemModel foodItem) {
        FoodItemModel foodItemCriado = foodItemService.salvar(foodItem);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(foodItemCriado);
    }

    //GET
    @GetMapping("/mostrar")
    public ResponseEntity<List<FoodItemModel>> mostrar() {
        List<FoodItemModel> listaFoodItemModel = foodItemService.listar();
        return ResponseEntity.status(HttpStatus.OK)
                .body(listaFoodItemModel);
    }

    //GET POR ID
    @GetMapping("/mostrar/{id}")
    public ResponseEntity<Object> mostrarPorID(@PathVariable Long id) {
        FoodItemModel foodItemID = foodItemService.listarPorId(id);
        if (foodItemID != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(foodItemID);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Food ID: " + id + " nao existe.");

        }

    }

    //UPDATE
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestBody FoodItemModel foodItem, @PathVariable Long id) {
        FoodItemModel foodItemEditado = foodItemService.editar(foodItem, id);
        if (foodItemEditado != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Food: " + foodItemEditado.getNome() + " editado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Food nao encontrada");
        }
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        FoodItemModel foodItemDeletado = foodItemService.deletar(id);
        if (foodItemDeletado != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Food: " + foodItemDeletado.getNome() + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Food ID: " + id + " nao existe.");
        }
    }
}
