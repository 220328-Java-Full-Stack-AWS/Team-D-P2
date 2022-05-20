export class Category {
  
    categoryId : number = 0
    categoryName : string = ""
    products:Product[]=[]
  
  
    constructor () {}
  
  }
  export class Product{
    productId=0
    category:Category={categoryId:0,categoryName:"",products:[]}
    productName:string=""
    description:string=""
    price:number=0
    constructor(){}
  }