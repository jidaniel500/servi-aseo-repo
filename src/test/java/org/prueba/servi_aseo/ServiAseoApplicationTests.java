package org.prueba.servi_aseo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.prueba.servi_aseo.entities.Producto;
import org.prueba.servi_aseo.repositories.IProductoRepository;
import org.prueba.servi_aseo.services.ProductoServicioService;
import org.prueba.servi_aseo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

import io.jsonwebtoken.security.InvalidKeyException;

@SpringBootTest
@EnableJpaRepositories(basePackages = "org.prueba.servi_aseo.repositories")
@ActiveProfiles("test") // Habilita los repositorios de JPA
class ServiAseoApplicationTests {

	private JwtUtil jwtUtil;

	@Autowired
	private ProductoServicioService productoService;

	@BeforeEach
	public void setUp() {
		// Inicializar JwtUtil antes de cada prueba
		jwtUtil = new JwtUtil();
	}

	@Test
	void generateToken() throws InvalidKeyException, Exception {
		Map<String, Object> claims = new HashMap<>();
		claims.put("daniel", "daniel123");
		String tokengenerado = jwtUtil.generateToken(claims);
		assertNotNull(tokengenerado);
		assertFalse(tokengenerado.isEmpty());
	}

	@Test
	public void buscarPorIds() {

		List<Integer> idstest = List.of(10, 20);
		List<Producto> list = productoService.getProductsByIds(idstest);
		assertNotNull(list);

	}

	@Test
	public void maxPrecioproductos() {

		List<Producto> maxProducts = productoService.getMaximoPrecio();
		assertNotNull(maxProducts);

	}

	@Test
	void calcularMontoTotal() {
		List<Integer> idsproducts = List.of(1, 2);
		BigDecimal total =  productoService.calcularMontoTotal(idsproducts, idsproducts);
		assertNotNull(total);
	}

}
