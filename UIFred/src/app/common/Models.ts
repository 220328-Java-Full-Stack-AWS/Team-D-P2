``
export class Category {
  
    categoryId : number = 0
    categoryName : string = ""
    products:Product[]=[]
  
  
    constructor () {}
  
  }
  export class Product{
    productId:number=0
    category:Category=new Category()
    productName:string=""
    description:string=""
    price:number=0
    imageUrl:string=""
    constructor(_productName: string, _description:string, _price:number,_imageURL:string){
      this.productName = _productName;
      this.description = _description;
      this.price = _price;
      this.imageUrl = _imageURL;
    }
  }
  export class Payment{
    id:number=0;
    cardNumber:string="";
    expirationDate:string='';
    cvvNumber:string="";
    user:User=new User("","","","","");
    constructor(_cardNumber:string,_expirationDate:string,_cvvNumber:string){
      this.cardNumber = _cardNumber;
      this.expirationDate = _expirationDate;
      this.cvvNumber = _cvvNumber;
    }
  }
  export class User {
    username: string = ""
    password: string = ""
    firstName: string = ""
    lastName: string = ""
    email: string = ""
  
    constructor(_username : string, _password : string, _firstName : string, _lastName: string, _email: string){
      this.username = _username;
      this.password = _password;
      this.firstName = _firstName;
      this.lastName = _lastName;
      this.email = _email;
    }
  }
  export class Cart {
      id:number = 0
      user :User = new User("","","","","");
      cartItems: Product[]=[]
      constructor(){}
  }