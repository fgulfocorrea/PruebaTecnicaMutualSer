<template>
  <div id="app">
    <div id="menuLeft">
        <nav class="navbar-expand-lg navbar-dark">
          <div id="navbarMenu" class="collapse navbar-collapse">
              <ul class="menu col-lg-12">
                    <li v-for="alcancia in alcancias" :key="alcancia.id" class="listaMenu col-sm-12 desplazamientoIzquierdo nav-item active">
                        <router-link id="pc" class="nav-link" :to="alcancia.nombre">{{alcancia.nombre}}</router-link>
                        <router-link id="movil" class="nav-link" data-toggle="collapse" data-target="#navbarMenu" :to="alcancia.nombre">{{alcancia.nombre}}</router-link>
                    </li>
              </ul>
          </div>
        </nav>
    </div>
    <div id="contenido">
      <router-view :key="$route.fullPath"/>
    </div>
  </div>
</template>

<script>
import PrincipalServicio from '@/services/PrincipalServicio'

export default {
  name: 'app',
  data () {
    return {
      alcancias: [],
    }
  },
  mounted () {
    this.listarAlcancias()
  },
  methods: {
    async listarAlcancias() {
      const response = await PrincipalServicio.obtenerAlcancias()
      console.log(response)
      this.alcancias = response.data.listaAlcancia
    }
  }
}
</script>

<style>
html {
  background: #FEFFFF;
  background-size: cover;
  height: 100%;
  overflow-y: scroll;
}
#movil{
  display: none;
}
#app {
  position: relative;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  height: 100hv;
  color: #2c3e50;
  margin-top: 0px;
}

/*.divBackground{
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
  width: 100%;
  height: 100vh;
  background-attachment: fixed;
  overflow: scroll;
  background-image: url('./assets/img/yellow-926728_1920.jpg');
}*/

#menuLeft{
  position: fixed;
  width:16%;
  background: #0443b8;
  top: 0;
  left: 0;
  height: 100vh;
  box-shadow:6px 0px 4px rgba(0,0,0,.5);
  opacity: 1;
}

#contenido{
  top: 0;
  right: 0;
  position: initial;
  padding-right: 0px;
  padding-left: 0px;
}

#divImg {
  width: 100%;
  height: 20%;
}

.logoBbd{
  padding-top: 14px;
  position: absolute;
  width: 100%;
  left: 2%;
  right: 2%;
}

#navbarMenu{
  margin-top: 0px;
  padding-top:30px;
}

.menu{
  margin-top: 0px;
  padding-left: 0px;
  padding-right: 0px;
}

.listaMenu{
  /*background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
  background-color: #dcee17;*/
  display: flex;
  margin-top: 20px;
  margin-left: 0px;
  padding-left: 0px;
  padding-right: 0px;
  justify-content: center;
  box-shadow:-3px 3px 3px rgba(0,0,0,.5);
  opacity: 0.9;
}

.listaMenu:hover{
  /*background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
  background-color: #f1f1ef;*/
  display: flex;
  margin-top: 20px;
  margin-left: 0px;
  padding-left: 0px;
  justify-content: center;
  box-shadow:-3px 3px 3px rgba(0,0,0,.5);
  opacity: 1;
  background: #8e9eab;  /* fallback for old browsers */
  background: -webkit-linear-gradient(to left, #eef2f3, #8e9eab);  /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to left, #eef2f3, #8e9eab); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

}

.nav-link{
  display: inline-block;
  position: relative;
  color: #ecff17;
  text-transform: uppercase;
  font-family: 'Sirin Stencil';
  font-weight: bolder;
  font-size: 0.84rem;
  cursor: pointer;
  padding-right: 0px;
  padding-left: 0px;
  width: 100%;
  height: 100%;
}

.nav-link:hover{
  display: inline-block;
  position: relative;
  color: #0443b8;
  text-transform: uppercase;
  font-family: 'Sirin Stencil';
  font-weight: bolder;
  font-size: 0.84rem;
  cursor: pointer;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

a{
  cursor: pointer;
}

li {
  display: inline-block;
  margin: 0 10px;
}
@-webkit-keyframes desplazamientoIzquierdo
{
0%
{
-webkit-transform: translateX(-200px);
transform: translateX(-200px);
}
100%
{
-webkit-transform: translateX(0px);
transform: translateX(0px);
}
}
.desplazamientoIzquierdo
{
-webkit-animation: desplazamientoIzquierdo 1s ease;
animation: desplazamientoIzquierdo 1s ease;
-webkit-animation-iteration-count: 1;
animation-iteration-count: 1;
}
</style>
