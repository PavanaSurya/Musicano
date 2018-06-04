<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<html>
<head>
<title>Instruments</title>
<meta charset="utf-8">
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
<link rel="stylesheet" type="text/css" href="${css}/styleinst.css">
</head>
<body>
<figure class="snip1423">
  <img src="${image}/M instruments/Bengali ektara.jpg" alt="sample57" />
  <figcaption>
    <h3>BENGALI EKTARA</h3>
    <p>Ektara is a one-string instrument most often used in traditional music from Bangladesh, Egypt. The ektara is a common instrument in Baul music from Bengal.</p>
    <div class="price">
      <s> &#8377 1,420.00</s> &#8377 800.00
    </div>
  </figcaption><i class="ion-android-cart"></i>
  <a href="<c:url value="/Cart1"/>"></a>
</figure>
<figure class="snip1423 hover">
<img src="${image}/M instruments/DHOL.jpg" alt="sample98" />
  <figcaption>
    <h3>DHOL</h3>
    <p>Dhol can refer to any one of a number of similar types of double-headed drum widely used, with regional variations, throughout the Indian subcontinent.</p>
    <div class="price">
      <s>&#8377 3,570.00</s>&#8377 1800.00
    </div>
  </figcaption><i class="ion-android-cart"></i>
  <a href="<c:url value="/Cart1"/>"></a>
</figure>
<figure class="snip1423">
<img src="${image}/M instruments/snare_drum.png" alt="sample90" />
  <figcaption>
    <h3>SNARE DRUM</h3>
    <p>A snare drum or side drum is a percussion instrument that produces a sharp staccato sound when the head is struck with a drum stick, due to the use of a series of stiff wires held under tension against the lower skin.</p>
    <div class="price">
      <s>&#8377 1800.00</s>&#8377 859.00
    </div>
  </figcaption><i class="ion-android-cart"></i>
  <a href="<c:url value="/Cart1"/>"></a>
</figure>
<figure class="snip1423">
<img src="${image}/M instruments/Lightweight wooden tambourine.jpg" alt="sample90" />
  <figcaption>
    <h3>SNARE DRUM</h3>
    <p>The tambourine is a musical instrument in the percussion family consisting of a frame, often of wood or plastic, with pairs of small metal jingles, called "zils".</p>
    <div class="price">
      <s>&#8377 1800.00</s>&#8377 859.00
    </div>
  </figcaption><i class="ion-android-cart"></i>
  <a href="<c:url value="/Cart1"/>"></a>
</figure>
</body>
</html>