### patten
window size is one zero
start = 0

loop through elemen => end (incrent)

  if( element == 0) // rely on end
     count++
  
  
  while( count > k)
   if(element == 0) //rely on start
     count--
   start++;

  res = Max (res, end-start)


example
======

[0,1,1,1,0,1,1,0,1]

start = 0,1
end =0 1 2 3
count =0, 1 2
sink at : 4,7
res =3
    
