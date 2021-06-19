import Api from '@/services/Api'
/* eslint-disable */
export default {
    obtenerMonedas(params) {
        return Api().get('moneda/listar/'+params.pais)
    },
}