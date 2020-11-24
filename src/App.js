import logo from './logo.svg';
import './App.css';
import axios from "axios";
import React from "react";


class App extends React.Component{

  constructor() {
    super()
    
    this.state = {
      fibonacciObj: {}
    }

}

componentDidMount(){
axios.get(`http://localhost:8080/fibonacci/allNumbers`).then(res => {
this.setState({ fibonacciObj: res.data})
console.log(this.state.fibonacciObj)
});

}



render() {
  return (
    <div className="App">
      <h1>Fibonacci-Reihe 1-100:</h1>
      <ol >
        {this.state.fibonacciObj.fibonaccis}
      </ol>
    </div>
  );
}
}
export default App;
//typeofArray
