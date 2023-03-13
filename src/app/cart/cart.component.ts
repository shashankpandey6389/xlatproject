import { Component, OnInit } from '@angular/core';
import { ThiscartService } from '../services/thiscart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  public product:any=[];
  public grandtotal !:number;
  constructor(private cartservice :ThiscartService) { }

  ngOnInit(): void {
    this.cartservice.getproducts()
    .subscribe(res=>{
      this.product=res;
      this.grandtotal=this.cartservice.gettotalprice();
    })
  }
  removeitem(item:any){
    this.cartservice.removecartitem(item);
  }
  emptycart(){
    this.cartservice.removeallcart();
  }
}
