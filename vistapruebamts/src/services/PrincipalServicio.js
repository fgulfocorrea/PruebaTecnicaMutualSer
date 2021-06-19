import Api from '@/services/Api'
/* eslint-disable */
export default {
  obtenerAlcancias() {
    return Api().get('principal')
  }
}