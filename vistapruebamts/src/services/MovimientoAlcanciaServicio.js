import Api from '@/services/Api'
/* eslint-disable */
export default {
    obtenerMovimientos(params) {
        return Api().get('movimiento')
    },
    obtenerCantidadMonedas(params) {
        return Api().get('movimiento/cantidadMonedas/'+params.idAlcancia)
    },
    obtenerCantidadMonedasPorDenominacion(params) {
        return Api().get('movimiento/cantidadMonedasPorDenominacion/'+params.idAlcancia+'/'+params.idMoneda)
    },
    obtenerDineroPorDenominacion(params) {
        return Api().get('movimiento/dineroPorDenominacion/'+params.idAlcancia+'/'+params.idMoneda)
    },
    guardarMovimiento(params) {
        return Api().post('movimiento/guardar/'+params.idAlcancia+'/'+params.idMoneda+'/'+params.cantidad)
    },
}