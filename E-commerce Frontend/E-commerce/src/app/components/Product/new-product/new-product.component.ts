import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ServiceProductService } from 'src/app/service/service-product.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Validate } from 'src/app/components/Product/Validate'

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  constructor(private service:ServiceProductService, private router:Router) { }

  public addForm!: FormGroup;
  private checkprice:any = /^([0-9]+\.?[0-9]*|[0-9]*\.[0-9]+)$/
  private Quantity:any = /^\d+$/

  ngOnInit(): void {
    this.addForm = this.createForm();
  }

  createForm() {
    return new FormGroup({
      identificationNumber: new FormControl('', Validators.compose([Validators.required, Validate.Idnumber])),
      name: new FormControl('', Validators.compose([Validators.required, Validators.maxLength(100)])),
      description: new FormControl('', Validators.compose([Validators.required, Validators.maxLength(280)])),
      base_Price: new FormControl('', Validators.compose([Validators.required, Validators.pattern(this.checkprice)])),
      tax_Rate: new FormControl('', Validators.compose([Validators.required, Validate.checkTax])),
      productstatus: new FormControl('', Validators.compose([Validators.required, Validators.pattern(/Published|Rough_copy/)])),
      quantity: new FormControl('', Validators.compose([Validators.required, Validators.pattern(this.Quantity)])),
      });
  }

  newProduct(){
    let product = new Product();
    product.identificationNumber = this.addForm.value.identificationNumber
    product.name = `${this.addForm.value.name}`;
    product.description = `${this.addForm.value.description}`;
    product.base_Price = this.addForm.value.base_Price;
    product.tax_Rate = this.addForm.value.tax_Rate;
    product.productstatus = `${this.addForm.value.productstatus}`;
    product.inventory = this.addForm.value.quantity; 
    console.log(product);
    this.service.createProduct(product).subscribe(() =>{
      alert("Agregado con exito");
      this.count(product)
      this.router.navigate(['homeuser']);
    })
  }

  count(product:Product){
    let temp: Product[] = []
    if(localStorage.getItem('home')===null){
      temp.push(product)
      localStorage.setItem('home', JSON.stringify(temp))
    }else{
      temp = JSON.parse(localStorage.getItem('home') || '{}')
      temp.push(product)
      localStorage.setItem('home', JSON.stringify(temp))
    }
  }

  back(){
    this.router.navigate(['homeuser'])
  }

}
