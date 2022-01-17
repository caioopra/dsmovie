import FormCard from 'components/FormCard';
import { useParams } from 'react-router-dom';

function Form() {

    const params = useParams();

    return (
        <FormCard movieId={`${params.movieId}`} /> // pega da url /form/x 
    );
}

export default Form;
