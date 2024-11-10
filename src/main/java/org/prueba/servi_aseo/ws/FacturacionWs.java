// package org.prueba.servi_aseo.ws;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.Objects;

// import org.prueba.servi_aseo.entities.Cliente;
// import org.prueba.servi_aseo.entities.Factura;
// import org.prueba.servi_aseo.entities.Response;
// import org.prueba.servi_aseo.models.FacturaModel;
// import org.prueba.servi_aseo.services.FacturacionService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// @RestController
// @RequestMapping("/api/facturacion")
// public class FacturacionWs {

//     @Autowired
//     private FacturacionService service;

//     @PostMapping("/crear")
//     public ResponseEntity<Response<FacturaModel>> create(@RequestBody FacturaModel facturamodel) {
//         Response<FacturaModel> respuesta = new Response<>();

//         try {
//             Factura factura = service.crear(facturamodel);
//             boolean factProdCreada = !Objects.isNull(factura) ?  service.registrarProductosFacturas(factura, facturamodel.getProductos()) : false;

//             respuesta.setMensaje("respuesta completada con exito");
//             respuesta.setIscompletada(true);
//             respuesta.setRespuesta(facturamodel);
             
//             return new ResponseEntity<Response<FacturaModel>>(respuesta, HttpStatus.ACCEPTED);

//         } catch (Exception e) {
//             respuesta.setIscompletada(false);
//             respuesta.setMensaje(e.getMessage());
//             respuesta.setRespuesta(null);
//             return new ResponseEntity<Response<FacturaModel>>(respuesta, HttpStatus.BAD_REQUEST);

//         }

//     }

// }