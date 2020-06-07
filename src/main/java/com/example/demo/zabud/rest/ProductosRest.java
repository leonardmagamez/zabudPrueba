package com.example.demo.zabud.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.zabud.dao.ProductDao;
import com.example.demo.zabud.entity.Productos;

@RestController
@RequestMapping("productos")
public class ProductosRest {
	
	@Autowired
	private ProductDao productosDao;
	
	@PostMapping
	public ResponseEntity<Productos> crearProductos(@RequestBody Productos producto){
		Productos product = productosDao.save(producto);
		return ResponseEntity.ok(product);
		
	}
	
	@PutMapping
	public ResponseEntity<Productos> editarProductos(@RequestBody Productos producto){
		Optional<Productos> product = productosDao.findById(producto.getCodigo());
		if(product.isPresent()) {
			Productos nuevoProducto = product.get();
			nuevoProducto.setNombre(producto.getNombre());
			nuevoProducto.setValor(producto.getValor());
			productosDao.save(nuevoProducto);
			return ResponseEntity.ok(nuevoProducto);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping(value = "{productoId}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("productoId") String productoId){
		productosDao.deleteById(productoId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping(value = "calcular")
	public ResponseEntity<Void> calcularValorFactura(){
		return null;
		
	}
	
	

}
