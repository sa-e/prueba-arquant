import React from 'react';
import styled from 'styled-components';


const Title = styled.h1`
display: flex;
justify-content: center;
color:white;
font-size: 6rem;
margin-top: 15%;
margin-bottom: 10px;
`;

const Subtitle = styled.p`
  margin-top: 10px;
  display: flex;
  justify-content: center;
  color:white;
  font-size: 2rem;
`;

function Header() {
  return (
    <><Title>Hi!</Title><Subtitle>Welcome to PruebaREACT</Subtitle></>
  );
}

export default Header;