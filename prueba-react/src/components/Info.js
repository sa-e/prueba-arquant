import React from 'react';
import styled from 'styled-components';
import { RiDeleteBinLine } from 'react-icons/ri';

function TrashIcon(props) {
  return <RiDeleteBinLine {...props} />;
}


const InfoWrapper = styled.div`
  background-color: #fff;
  padding: 1rem;
  border: 1px solid black;
  border-radius: 0.50rem;
`;

const InfoTitle = styled.h2`
  font-size: 1.5rem;
  margin-bottom: 1rem;
`;

const InfoItem = styled.p`
  font-size: 1rem;
`;

const Button = styled.button`
  background-color: red;
  color: white;
  border: none;
  border-radius: 1rem;
`;


function Info({ name, gender, hairColor, onDelete }) {
  return (
    <InfoWrapper>
      <InfoTitle>{name}</InfoTitle>
      <InfoItem>Gender ooo: {gender}</InfoItem>
      <InfoItem>Hair Color: {hairColor}</InfoItem>
      <Button onClick={onDelete}><TrashIcon size={22} color="white"/></Button>
    </InfoWrapper>
  );
}

export default Info;