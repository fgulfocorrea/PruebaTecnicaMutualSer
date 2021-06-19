import Api from '@/services/Api'
/* eslint-disable */
export default {
    obtenerAlcanciaNombre(params) {
        return Api().get('alcancia/'+params.nombre)
    },
}