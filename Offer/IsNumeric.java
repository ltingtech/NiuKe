package Offer;


public class IsNumeric {

	public static void main(String[] args) {
		IsNumeric instance=new IsNumeric();
		char[] str="123.45e+6".toCharArray();
		boolean result=instance.isNumeric(str);
		System.out.println(result);

	}
//	public boolean isNumeric(char[] str) {
//	        boolean result=false;
//	        if(str!=null && str.length>0)
//	            {
//	            int eIdx=-1;
//	        	for(int i=0;i<str.length;i++){
//	                if(str[i]=='e'|| str[i]=='E'){
//	                    eIdx=i;
//	                    break;
//	                }
//	            }
//	            if(eIdx==-1){
//	                result=isFloatNum(str,0,str.length-1);
//	            }
//	            else{
//	            	if((eIdx+1)<str.length&& (str[eIdx+1]=='+'||str[eIdx+1]=='-'))
//	            	{
//	            		result=isFloatNum(str,0,eIdx-1)&&isIntegerNum(str,eIdx+2,str.length-1);
//	            	}
//	            	else {
//	            		result=isFloatNum(str,0,eIdx-1)&&isIntegerNum(str,eIdx+1,str.length-1);
//					}
//	                
//	            }
//	        }
//	        return result;
//	        
//	        
//	    }
	    
	    private boolean isFloatNum(char[] str,int first,int end){
	        boolean result=true;
	        if(first>end){
	            result=false;
	        }
	        if(first<=end){
	            if(first==end){
	                if(str[first]>='0' && str[end]<='9'){
	                    result=true;
	                }
	                else{
	                    result=false;
	                }
	            }
	            else{
	               if(str[first]=='-'||str[first]=='+'){
	                   result=isPositiveFloat(str,first+1,end);
	               }
	                else{
	                    result=isPositiveFloat(str,first,end);
	                }
	            }
	        }
	        return result;
	    }
	    private boolean isPositiveFloat(char[] str,int first,int end){
	        boolean result=true;
	        if(first>end){
	            result=false;
	        }
	        if(first<=end){
	            if(first==end){
	                if(str[first]>='0' && str[end]<='9'){
	                    result=true;
	                }
	            }
	            else{
	              if(str[first]>='0'&&str[first]<='9'){
	                  boolean point=false;
	                  for(int i=first+1;i<=end;i++){
	                      if(str[i]=='.')
	                          {
	                          if(!point){
	                              point=true;
	                              continue;
	                          }
	                          else{
	                              result=false;
	                              break;
	                          }
	                      }
	                      else{
	                          if(str[i]>='0'&& str[i]<='9')
	                              {
	                              continue;
	                          }
	                          else{
	                              result=false;
	                              break;
	                          }
	                      }
	                  }
	              	}  
	                else{
	                    result=false;
	                }
	            }   
	        }
	        return result;
	    }
	    private boolean isIntegerNum(char[] str,int first,int end){
	        boolean result=true;
	        if(first>end){
	            result=false;
	        }
	        if(first<=end){
	            if(first==end){
	                if(str[first]>'0'&& str[first]<='9')
	                    {
	                    result=true;
	                }
	                else{
	                    result=false;
	                }
	            }
	            else{
	                if(str[first]=='0'){
	                   result=false;
	                }
	                else{
	                    for(int i=first;i<=end;i++){
	                        if(str[i]>='0' && str[i]<='9'){
	                            continue;
	                        }
	                        else{
	                            result=false;
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	        return result;
	    }

	    public boolean isNumeric(char[] str){
	    	if(str==null||str.length<=0){
	    		return false;
	    	}
	    	else{
	    		boolean result=false;
	    		int len=str.length;
	    		int currIdx=0;
	    		if(str[0]=='+'||str[0]=='-'){
	    			currIdx++;
	    		}
	    		currIdx=scanNum(str, currIdx);
	    		if(currIdx==-1){
	    			result=false;
	    		}
	    		else{
	    			if(currIdx==str.length){
	    				result=true;
	    			}
	    			else{
	    				if(str[currIdx]=='.'){
	    					currIdx++;              //+2424.[3]867
	    					currIdx=scanNum(str, currIdx);
	    					if(currIdx==-1){
	    						result=false;
	    					}
	    					else{
	    						if(currIdx==str.length){
	    							result=true;   //实例： +234.323, -232.  等
	    						}
	    						else{
	    							result=isExpotential(str, currIdx);
	    						}
	    					}
	    				}
	    				else{
	    					result=isExpotential(str, currIdx);
	    				}
	    			}
	    		}
	    		return result;
	    	}
	    	
	    }
	    private int scanNum(char[] str,int startIdx){
	    	int result=-1;
	    	if(startIdx<str.length){
	    		while(startIdx<str.length){
	    			if(str[startIdx]>='0'&& str[startIdx]<='9'){
	    				startIdx++;
	    			}
	    			else{
	    				result=startIdx;
	    				break;
	    			}
	    		}
	    		if(startIdx==str.length){
	    			result=startIdx;
	    		}
	    	}
	    	
	    	return result;
	    }
	    private boolean isExpotential(char[] str,int startIdx){
	    	int currIdx=startIdx;
	    	boolean result=true;
	    	if(currIdx<str.length){
	    		if(str[currIdx]=='e'||str[currIdx]=='E'){ //+242.353e[]  224.e[]
					currIdx++;
					if(currIdx==str.length){
						result=false;
					}
					else{
						if(str[currIdx]=='+'||str[currIdx]=='-'){
							currIdx++;
						}
						if(currIdx==str.length){
							result=false;
						}
						else{
							currIdx=scanNum(str, currIdx);
							if(currIdx==str.length){
								result=true;
							}
							else{
								result=false;
							}
						}
					}
				}
				else{
					result=false;
				}
	    	}
	    	else{
	    		result=true;
	    	}
	    	return result;
	    }

}
