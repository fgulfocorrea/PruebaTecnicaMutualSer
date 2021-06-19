<template>
    <div class="Alcancia">
        <div class="card-body card-body-alcancia text-center">
          <h4 class="titulo1">{{titulo}}</h4>
            <form>
              <div class="col-sm-12 mitabla">
                <table>
                  <thead>
                      <th>Pais</th>
                      <th>Nombre</th>
                      <th>Total Monedas</th>
                      <th>Total Dinero</th>
                  </thead>
                      <tr>
                          <td>{{ alcancia.pais }}</td>
                          <td>{{ alcancia.nombre }}</td>
                          <td>{{ cantidadMonedas }}</td>
                          <td>$ {{ alcancia.totalDinero }}</td>
                      </tr>
                  </table>
                </div>
                <div class="row">
                  <div class="col-sm-12 text-left">
                    <h4 class="titulo2">Agregar Monedas</h4>
                    <label for="moneda">Monedas </label>
                    <select v-model="monedaSeleccionado" class="form-control" id="moneda">
                        <option v-for="moneda in monedas" :key="moneda.id" :value="moneda">{{moneda.nombre}}</option>
                    </select>
                    <label for="inputCantidad" class="sr-only">Cantidad </label>
                    <input
                    v-model="cantidad"
                    type="text"
                    id="inputCantidad"
                    class="form-control"
                    placeholder="Cantidad"
                    required
                    autofocus
                    ref="cantidad"
                    />
                    <button type="submit" @click.prevent="guardarMonedas" class="btn btn-outline-info active">Agregar</button>
              </div>
            </div>
          </form>
          <div class="row"/>
            <form>
            <h4 class="titulo2">Cantidad Monedas Por Denominación</h4>
            <label for="denominacion">Denominacion </label>
            <select v-model="denominacionSeleccionado" class="form-control" id="denominacionCantidad">
                <option v-for="moneda in monedas" :key="moneda.id" :value="moneda">{{moneda.nombre}}</option>
            </select>
            <button type="submit" @click.prevent="buscarCantidadDenominacion" class="btn btn-outline-info active">Buscar</button>
            </form>
            <div class="row">
              <label for="cantidadDenominacion">Cantidad : {{ cantidadDenominacion }} </label>
            </div>
            <div class="row"/>
            <form>
              <h4 class="titulo2">Total Dinero Por Denominación</h4>
              <label for="denominacion">Denominacion </label>
              <select v-model="denominacionDineroSeleccionado" class="form-control" id="denominacionDinero">
                  <option v-for="moneda in monedas" :key="moneda.id" :value="moneda">{{moneda.nombre}}</option>
              </select>
              <button type="submit" @click.prevent="buscarDineroDenominacion" class="btn btn-outline-info active">Buscar</button>
            </form>
            <div class="row">
              <label for="cantidadDenominacion">Total Dinero : $ {{ cantidadDineroDenominacion }} </label>
            </div>
        </div>
    </div>
</template>

<script>
/* eslint-disable */

import alcanciaServicio from '@/services/AlcanciaServicio'
import monedaServicio from '@/services/MonedaServicio'
import movimientoAlcanciaServicio from '@/services/MovimientoAlcanciaServicio'

export default {
    name: 'Alcancia',
    data (){
      return {
        alcancia:{},
        titulo: "Alcancia",
        monedas: [],
        denominaciones: [],
        denominacionSeleccionado: {},
        denominacionDineroSeleccionado: {},
        monedaSeleccionado: {},
        cantidad:"",
        cantidadMonedas:"",
        cantidadDenominacion:"",
        cantidadDineroDenominacion:""
      }
    },
    beforeUpdate(){
    },
    methods: {

      async obtenerInfoAlcancia(nombre) {
          console.log("nombre:"+nombre)
        const response = await alcanciaServicio.obtenerAlcanciaNombre({nombre: nombre});
        console.log(response.data)
        this.alcancia = response.data.alcancia
        console.log("pais:"+this.alcancia.pais)
        this.obtenerMonedas(this.alcancia.pais);
        this.obtenerCantidadMonedas()
      },

      async obtenerMonedas(pais) {
          console.log("nombre:"+pais)
        const response = await monedaServicio.obtenerMonedas({pais: pais});
        console.log(response.data)
        this.monedas = response.data.listaMonedas
        this.denominaciones = response.data.listaMonedas
      },
      async guardarMonedas() {
            const response = await movimientoAlcanciaServicio.guardarMovimiento({
              idAlcancia:this.alcancia.id,
              idMoneda:this.monedaSeleccionado.id,
              cantidad:this.cantidad
            });
            // toastr.success(response.data.message);
            // this.listarOpciones()
            this.limpiarObjeto()
            this.obtenerInfoAlcancia(this.$route.params.nombre);
      },
      async obtenerCantidadMonedas() {
          const response = await movimientoAlcanciaServicio.obtenerCantidadMonedas({
            idAlcancia:this.alcancia.id
          });
          this.cantidadMonedas = response.data.cantidadMonedas
      },
      limpiarObjeto() {
        this.alcancia.id = null
        this.alcancia.nombre = ''
        this.alcancia.pais = ''
        this.alcancia.totalDinero = null
        this.cantidad = ''
        this.monedaSeleccionado = {}
      },
      async buscarCantidadDenominacion() {
        const response = await movimientoAlcanciaServicio.obtenerCantidadMonedasPorDenominacion({
          idAlcancia:this.alcancia.id,
          idMoneda:this.denominacionSeleccionado.id
        });
        this.cantidadDenominacion = response.data.cantidadMonedasPorDenominacion
      },
      async buscarDineroDenominacion() {
        const response = await movimientoAlcanciaServicio.obtenerDineroPorDenominacion({
          idAlcancia:this.alcancia.id,
          idMoneda:this.denominacionDineroSeleccionado.id
        });
        this.cantidadDineroDenominacion = response.data.cantidadDineroPorDenominacion
      }
    },
    mounted() {
        this.obtenerInfoAlcancia(this.$route.params.nombre);
    },

}
</script>
<style>

.titulo1{
  border-bottom-style: inset
}
.titulo2{
  border-bottom-style: inset
}
.crud-administracion{
  padding-top: 5px;
}
.card-body-alcancia {
  padding: 0px;
}
.mitabla{
  text-align: -webkit-center;
}
table {
  border: 2px solid #0443b8;
  border-radius: 3px;
  background-color: #fff;
  text-align: -webkit-center;
}

th {
  background-color: #0443b8;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #f9f9f9;
}

th, td {
  min-width: 120px;
  padding: 10px 20px;
}

th.active {
  color: #fff;
}
</style>