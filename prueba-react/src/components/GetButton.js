import React from 'react';
import styled from 'styled-components';

const GetPeopleButtonWrapper = styled.div`
    display: flex;
    justify-content: center;
    width: 100%;
`;

const Button = styled.button`
    margin-top: 3vh;
    font-size: 2rem;
    width:20vh;
    height: 5vh;
    border: none;
    background-color: red;
    justify-content: center;
    color:white;
    border-radius: 0.50rem;
`;

function GetPeopleButton({Get}) {
  return (
    <GetPeopleButtonWrapper>
      <Button onClick={Get}>Get People</Button>
    </GetPeopleButtonWrapper>
  );
}

export default GetPeopleButton;