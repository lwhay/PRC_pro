<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script src="js/jQuery/jquery-2.1.4.min.js"></script>
	<script src="js/queryjs/queryjs.js" type="text/javascript"></script>
	<script src="../3dshow/libs/three.js"></script>
   <script src="../3dshow/libs/OBJLoader.js"></script>
   <script src="../3dshow/libs/OrbitControls.js"></script>
   <script src="../3dshow/libs/RequestAnimationFrame.js"></script>
   <script src="../3dshow/libs/Detector.js"></script>
<body>
	
	<div align="center">
		<script type="text/javascript">		
			var scene;
	        var loader;
	        var light;
	        var camera;
	        var renderer;
	        var controls;
	        var geometry;
	        var mesh;
	        var dogObject;
	        
	      //  var show = $('#correlation');
	
	        init();
	        animate();
		
			function init(){
				scene = new THREE.Scene();
				//3d
				geometry = new THREE.BoxGeometry(50,50,50);
	            var material = new THREE.MeshLambertMaterial({
	                color:0xff0000
	            });
	            mesh = new THREE.Mesh(geometry,material);
	            mesh.position.x = 80;
	            mesh.position.y = 0;
	            mesh.position.z = 0;
	            mesh.name = 'box1';
	            scene.add(mesh);
	
	            mesh = new THREE.Mesh(geometry,material);
	            mesh.position.x = 80;
	            mesh.position.y = 40;
	            mesh.position.z = 40;
	            mesh.name = 'box2';
	            scene.add(mesh);
				
				 // OBJ
				loader = new THREE.OBJLoader();
		        loader.load('../3dshow/doc/dog.obj',function (dogObject) {
		            dogObject.scale.set(0.2,0.2,0.2);
		            dogObject.position.y=-30;
		            dogObject.position.x=-30;
		            dogObject.position.z=-30;
		            scene.add(dogObject);
		        });
		        // Skybox
		        scene.background = new THREE.CubeTextureLoader()
		            .setPath( '../3dshow/pisa/' )
		            .load( [ 'px.png', 'nx.png', 'py.png', 'ny.png', 'pz.png', 'nz.png' ] );
		        
		        light = new THREE.PointLight(0xffffff);
		        light.position.set(300,400,200);
		        scene.add(light);
		        scene.add(new THREE.AmbientLight(0x333333));
		
		        camera = new THREE.PerspectiveCamera(40,800/600,1,2000);
		        camera.position.set(200,200,200);
		        camera.lookAt(scene.position);
		
		        renderer = new THREE.WebGLRenderer();
		        renderer.setSize(586,450);
		        document.body.appendChild(renderer.domElement);
		        
		        controls = new THREE.OrbitControls(camera);
		        controls.addEventListener('change',render);
		        document.addEventListener('mouseup',onDocumentMouseUP,false );
			}
	        	
	        function render(){
	            renderer.render(scene,camera);
	        }
	
	        function animate(){
	            requestAnimationFrame(animate);
	            render();
	        }
	        
	        function onDocumentMouseUP( event ) {        
	            event.preventDefault();
	            var vector = new THREE.Vector3();//三维坐标对象
	            vector.set(
	                ( (event.clientX-690)/ 586) * 2 - 1,
	                -( (event.clientY-98)/ 450 ) * 2 + 1,
	                0.5);
	            vector.unproject(camera);
	            var raycaster = new THREE.Raycaster(camera.position, vector.sub(camera.position).normalize());
	            var intersects = raycaster.intersectObjects(scene.children);
	            if (intersects.length > 0) {
	               // alert("this is " + intersects[0].object.name);
	                document.getElementById('correlation').value= document.getElementById('correlation').value
	                +"click the " + intersects[0].object.name + "\n";	                
	                //document.getElementById('correlation').value=  
		        	//	document.getElementById('correlation').value + "\n"
		        	//	+ event.clientX + "," + event.clientY + "->" 
		        	//	+ (event.clientX-690) + "," + (event.clientY-98);
		        	}
	        }
	        
	    </script>
   </div>
</body>
</html>
