import axios from 'axios'

/* eslint-disable */

export default() => {
  return axios.create({
    baseURL: 'http://localhost:8080/api/'
    //baseURL: 'http://198.211.10.12:8081'
    //baseURL: 'http://173.82.240.52:8082'
  })
}