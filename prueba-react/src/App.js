import React, { useState } from 'react';
import axios from 'axios';
import Info from './components/Info';
import GetButton from './components/GetButton'
import styled from 'styled-components';
import LoadingComponent from './components/LoadingComponent';
import Header from './components/Header';


function App() {
  const [people, setPeople] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  const fetchPeople = () => {
    setIsLoading(true);
    setTimeout(() => {
      axios.get('https://swapi.dev/api/people/')
        .then(response => {
          const results = response.data.results.slice(0, 10).map(person => ({
            name: person.name,
            gender: person.gender,
            hairColor: person.hair_color,
          }));
          setPeople(results);
          setIsLoading(false);
        })
        .catch(error => {
          console.log(error);
          setIsLoading(false);
        });
    }, 1500); 
  }

  const handleDelete = index => {
    setPeople(prevState => {
      const newPeople = [...prevState];
      newPeople.splice(index, 1);
      return newPeople;
    });
  }

  const Background = styled.div`
    background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),url("https://images.pexels.com/photos/546819/pexels-photo-546819.jpeg");
    background-repeat: no-repeat;
    background-attachment: fixed;   
    background-size: cover;
    height: 100vh;
    align-content: center;
    display: flex;
    justify-content: center;
    margin:0 auto;
  `;

  const Container = styled.div`
    margin: 0 auto;
    min-height: 25vh;
    max-height: 60vh;
    width: 60vh;
    display: block;
    overflow: auto;
    align-content: center;    
    justify-content: center;
  `;

  return (
      <Background>
        <div >
          <Header/>
          <Container>
            {isLoading ? (              
                <LoadingComponent/>              
            ) : people.length === 0 ? (              
                <GetButton Get={() => fetchPeople()}/>              
            ) : (
              <div>
                {people.map((person, index) => (
                  <Info
                    key={index}
                    name={person.name}
                    gender={person.gender}
                    hairColor={person.hairColor}
                    onDelete={() => handleDelete(index)}
                  />
                ))}
              </div>          
            )}
          </Container>
        </div>
      </Background>
  );
}

export default App;
