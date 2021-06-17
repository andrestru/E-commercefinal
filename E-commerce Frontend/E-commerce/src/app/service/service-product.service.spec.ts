import { TestBed } from '@angular/core/testing';
import { ServiceProductService } from '../service/service-product.service'
import { of, throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';

describe('Service: serviceProductService', () =>{
    let httpClientSpy: { get: jasmine.Spy};
    let service: ServiceProductService;

    beforeEach(()=>{
        httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
        service = new ServiceProductService(httpClientSpy as any);
    });

    fit('should return expected Product (HttpClient called once)', () => {
        const expectedUsers = [
          { identificationNumber: 231, name: 'B', description: 'DESB', base_Price: 4000, tax_Rate: 0.3, productstatus:'Published', inventory:2 }
        ];
    
        httpClientSpy.get.and.returnValue(of(expectedUsers));
    
        service.getProduct("http://localhost:8080/product");
    
        expect(service.getProduct.length).toBe(1);
        expect(httpClientSpy.get.calls.count()).toBe(1, 'one call');

      });

      it('should return an error when the server returns a 404', () => {
        const errorResponse = new HttpErrorResponse({
          error: 'test 404 error',
          status: 404,
          statusText: 'Not Found'
        });
    
        httpClientSpy.get.and.returnValue(throwError(errorResponse));
    
        service.getProduct("http://localhost:8080/product");
    
        expect(service.getProduct).toBeUndefined();
      });
})
