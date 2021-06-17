import { TestBed } from '@angular/core/testing';
import { of, throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';


import { ServiceOrderService } from './service-order.service';

describe('ServiceOrderService', () => {
  let httpClientSpy : {get:jasmine.Spy}
  let service: ServiceOrderService;

  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get'])
    service = new ServiceOrderService(httpClientSpy as any)
  });

  fit('should return expected Product (HttpClient called once)', () => {
    const order = [{
      number_order: '2ms1', name:'name', address:'address', identification:123, orderstatus:'approved', description:'des', total:1000
    }]
    httpClientSpy.get.and.returnValue(of(order));
    service.getOrder();
    expect(httpClientSpy.get.calls.count()).toBe(1, 'one call');
  });

  it('should return an error when the server returns a 404', () => {
    const errorResponse = new HttpErrorResponse({
      error: 'test 404 error',
      status: 404,
      statusText: 'Not Found'
    });

    httpClientSpy.get.and.returnValue(throwError(errorResponse));

    service.getOrder();

    expect(service.getOrder).toBeUndefined();
  });
});
