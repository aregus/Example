# PertChart

Data Structures  
• NetworkTable  
• ArrayHeap  

Algorithm for findPaths  

1.	create path heap   
2.	succAvail <- true  
3.	create first entry in heap  
    a.	get first entry from NetworkTable  
    b.	get cost of first entry  
    c.	get label of first entry  
    d.	insert cost and first label into path heap  
4.	repeat while succAvail is true  
    a.	succAvail <- false  
    b.	create a temp heap  
    c.	while there are entries in the path heap  
            i.	remove the top entry from the heap  
            ii.	get the last entry name from the entry list  
            iii.	get the successor list for the last entry name  
            iv.	for each entry in the successor list  
                1.	get the entry for the successor  
                2.	calculate the cost of the successor to the cost of the top entry  
                3.	append the label of successor to the top entry list  
                4.	insert the new cost and the new list into the temp heap  
                5.	if the successor has a successor then  
                    a.	succAvail <- true  
    d.	copy temp heap to path heap  
 

