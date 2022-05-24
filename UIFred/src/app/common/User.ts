export class User{
    constructor(_username:string,_password:string,_firstname:string,_lastname:string,_enabled:boolean,_email:string,_phone:string,
                _streetName:string,_city:string,_state:string,_zipCode:string)
                {
                    this.username = _username,
                    this.password = _password,
                    this.firstName = _firstname,
                    this.lastName = _lastname,
                    this.enabled = _enabled,
                    this.email = _email,
                    this.phone = _phone,
                    this.streetName = _streetName,
                    this.city = _city,
                    this.state = _state,
                    this.zipCode = _zipCode
                }
    id!:number;
    username!:string;
    password!:string;
    firstName!:string;
    enabled!:boolean;
    lastName!:string;
    email!:string;
    phone!:string;
    streetName!:string;
    city!:string;
    state!:string;
    zipCode!:string;
    cart!:Object;
    paymentMethods!:Object[];
}
