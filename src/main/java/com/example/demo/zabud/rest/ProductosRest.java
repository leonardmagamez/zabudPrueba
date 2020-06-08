package com.example.demo.zabud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.zabud.dao.FacturaDao;
import com.example.demo.zabud.dao.ItemDao;
import com.example.demo.zabud.dao.ProductDao;
import com.example.demo.zabud.entity.Factura;
import com.example.demo.zabud.entity.Productos;

@RestController
@RequestMapping("productos")
public class ProductosRest {

	@Autowired
	private ProductDao productosDao;

	@Autowired
	private ItemDao itemDao;

	@Autowired
	private FacturaDao facturaDao;

	@PostMapping
	public ResponseEntity<Productos> crearProductos(@RequestBody Productos producto) {
		Productos product = productosDao.save(producto);
		return ResponseEntity.ok(product);

	}

	@PutMapping
	public ResponseEntity<Productos> editarProductos(@RequestBody Productos producto) {
		Productos product = productosDao.findByCodigo(producto.getCodigo());
		if (product != null) {
			Productos nuevoProducto = product;
			nuevoProducto.setNombre(producto.getNombre());
			nuevoProducto.setValor(producto.getValor());
			productosDao.save(nuevoProducto);
			return ResponseEntity.ok(nuevoProducto);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping(value = "{productoId}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("productoId") String productoId) {
		Productos product = productosDao.findByCodigo(productoId);
		productosDao.deleteById(product.getId());
		return ResponseEntity.ok(null);
	}

	@PostMapping(value = "calcular")
	public ResponseEntity<Factura> calcularValorFactura(@RequestBody Factura factura) {
		Double valorTotalItem = 0.0;
		Double valorTotalFactura = 0.0;
		valorTotalItem = valorTotalItem
				+ factura.getItemId().getCantidad() * factura.getItemId().getProductoId().getValor();
		valorTotalFactura = valorTotalFactura + valorTotalItem;
		factura.getItemId().setValorTotal(valorTotalItem);
		factura.setValorTotal(valorTotalFactura);
		return ResponseEntity.ok(factura);

	}

}
