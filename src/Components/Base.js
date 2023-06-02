
import CustomNav from "./CustomNav";


const Base=({title="Welcome to Inventory Management",children})=>{
    return(
        <div>
          <CustomNav/>

            {children}
            
        </div>
    );
}

export default Base;
