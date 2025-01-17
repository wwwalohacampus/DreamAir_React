package com.joeun.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joeun.server.dto.Product;
import com.joeun.server.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/flight")
public class FlightContorller {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        log.info("[GET] - /flight - 항공기 목록");
        try {
            List<Product> flightList = productService.flight_list();
            if( flightList == null )
            log.info("조회된 항공기 목록 없음");
        else 
            log.info("항공기 목록 수 : " + flightList.size());

        return new ResponseEntity<>(flightList, HttpStatus.OK);
        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{flightNo}")
    public ResponseEntity<?> getOne(@PathVariable Integer flightNo) {
        log.info("[GET] - /flight/" + flightNo  + " - 항공기 목록 조회");
        try {
             Product flight = productService.flight_select(flightNo);
             if( flight == null ) {
                 flight = new Product();
                 return new ResponseEntity<>(flight, HttpStatus.OK);
             }
             else {
                 return new ResponseEntity<>(flight, HttpStatus.OK); 
             }
         } catch (Exception e) {
             log.error(null, e);
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
    
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Product flight) {
        log.info("[POST] - /flight - 항공기 등록");
        try {
            int result = productService.flight_insert(flight);
            if( result > 0 )
                return new ResponseEntity<>("항공기 등록 완료", HttpStatus.CREATED);  // 201
            else
                return new ResponseEntity<>("항공기 등록 실패", HttpStatus.OK);  

        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Product flight) {
        log.info("[PUT] - /flight - 항공기 수정");
        int flightNo = flight.getFlightNo();
        log.info("flightNo 확인 : ");
        try {
            int result = productService.flight_update(flightNo);
            if( result > 0 )
                return new ResponseEntity<>("항공기 수정 완료", HttpStatus.OK); 
            else
                return new ResponseEntity<>("항공기 수정 실패", HttpStatus.OK);
        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{flightNo}")
    public ResponseEntity<?> destroy(@PathVariable Integer flightNo) {
        log.info("[DELETE] - /flight/" + flightNo + " - 항공기 삭제");
        try {
            int result = productService.flight_delete(flightNo);
            if( result > 0 )
                return new ResponseEntity<>("항공기 삭제 완료", HttpStatus.OK); 
            else
                return new ResponseEntity<>("항공기 삭제 실패", HttpStatus.OK);
        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
