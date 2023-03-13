import { Component, OnInit } from '@angular/core';
import { FakeapiService } from '../services/fakeapi.service';
import { ThiscartService } from '../services/thiscart.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
public productList:any;
  constructor(private api:FakeapiService,private cartservice:ThiscartService) { }

  ngOnInit(): void {
    this.api.getProduct()
    .subscribe(res=>{
      this.productList=res;
      this.productList.forEach((a:any)=>{
        Object.assign(a,{quantity:1,total:a.price});
      })
    })
  }
addtocart(item:any){
  this.cartservice.addtocart(item);
}
}
